#!/bin/bash

capitalize_first_letter() {
  local input="$1"
  local first_letter="$(echo "${input:0:1}" | tr '[:lower:]' '[:upper:]')"
  local remaining_letters="${input:1}"
  echo "${first_letter}${remaining_letters}"
}

capitalize_text() {
  local input="$1"
  local capitalized_text="$(echo "$input" | tr '[:lower:]' '[:upper:]')"
  echo "$capitalized_text"
}

lowercase_text() {
  local input="$1"
  local lowercase_text="$(echo "$input" | tr '[:upper:]' '[:lower:]')"
  echo "$lowercase_text"
}

# Function to rename words in file contents
rename_file_contents() {
  local folder="$1"
  local from="$2"
  local to="$3"

  echo "Renaming file contents from $from to $to in the directory $folder"

  # Find files matching the pattern recursively and exclude the .git directory
  files=$(grep -rl "$from" "$folder" --exclude-dir=".git" 2>/dev/null)

  # Check if any files were found
  if [ -z "$files" ]; then
    echo "No files found containing the word '$from'. Skipping renaming."
    return
  fi

  # Iterate over the files and replace the contents
  for file in $files; do
    # Use sed to perform the replacement in the file contents and save it to a temporary file
    sed "s/$from/$to/g" "$file" > "$file.tmp" && mv "$file.tmp" "$file" || echo "Error: Failed to replace contents in '$file'"
  done
}

# Function to recursively rename files
rename_files() {
  local folder="$1"
  local from="$2"
  local to="$3"

  echo "Renaming files and directories from $from to $to in the directory $folder"

  # Find files and directories matching the pattern recursively and redirect error messages to /dev/null
  # Note the use of -print0 and -0 for handling filenames with spaces or special characters correctly
  find "$folder" -depth -name "*$from*" -print0 2>/dev/null | while IFS= read -r -d '' path; do
    # Perform the replacement in the filename or directory name
    new_path=$(echo "$path" | sed "s/$from/$to/")

    # Rename the file or directory
    mv "$path" "$new_path" || echo "Error: Failed to rename '$path' to '$new_path'"
  done
}

build_archetype() {
  local folder="$1"
  local from="$2"
  local to="$3"

  rename_file_contents "$folder" "$from" "$to"
  rename_files "$folder" "$from" "$to"
}

# Check if the script is called with the correct number of arguments
if [ $# -ne 4 ]; then
  echo "Usage: $0 <folder> <new_folder> <from> <to>"
  exit 1
fi

# Get the arguments
folder="$1"
new_folder="$2"
from="$3"
to="$4"

# Check if the folder exists before proceeding
if [ ! -d "$folder" ]; then
  echo "Error: The source folder '$folder' does not exist."
  exit 1
fi

# Check if the new folder already exists
if [ -d "$new_folder" ]; then
  echo "Error: The destination folder '$new_folder' already exists. Please choose a different name."
  exit 1
fi

echo "Copying all files to the new folder structure."

cp -r "$folder/" "$new_folder/"

# Give permissions
chmod u+w $new_folder

echo "Files copied successfully."

build_archetype "$new_folder" "$(capitalize_first_letter "$from")" "$(capitalize_first_letter "$to")"
build_archetype "$new_folder" "$(capitalize_text "$from")" "$(capitalize_text "$to")"
build_archetype "$new_folder" "$(lowercase_text "$from")" "$(lowercase_text "$to")"
