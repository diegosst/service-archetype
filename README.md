# Archetype Service Generator

This script, `archetype-builder.sh`, is a tool for generating services quickly and easily based in an archetype.

## Usage

To use the `archetype-builder.sh` script, follow the instructions below:

```bash
sh archetype-builder.sh <folder> <new_folder> <service_name> [optional: company_name]
```

### Parameters

- `<folder>`: The source folder containing the initial service structure that will be used to create the archetype.


- `<new_folder>`: The name of the new folder where the generated archetype will be stored.


- `<service_name>`: The name of the service. This name will be used to perform various replacements in the generated files.


- `[optional: company_name]`: An optional parameter representing the name of the company. If provided, the script will use this name in the generated files.

## Examples

### Example 1:

Generate a service archetype named "price-service" based on the contents of the "service" folder:

```bash
sh archetype-builder.sh service price-service price
```

### Example 2:

Generate a service archetype named "price-service" for the company "mycompany" based on the contents of the "service" folder:

```bash
sh archetype-builder.sh service price-service price mycompany
```

## Notes

- The script looks for the word `archetype` to the base service name and `diegosst` as base company name in order to do the replacements.


- The script will create a new folder with the specified `<new_folder>` name and copy all files from the `<folder>` into it. The script will then perform various replacements in the copied files, replacing occurrences of "ARCHETYPE" with the provided `<service_name>` and "COMPANY" with the optional `<company_name>`.


- The generated archetype will be a starting point for your new service project, and you can further customize it according to your specific needs.


- Please ensure that you have the necessary permissions to read from the source folder and write to the destination folder.


- The script is designed to work with `bash`. Make sure you have the correct permissions and the bash interpreter available on your system.


Feel free to use this script to streamline your service archetype creation process and accelerate your development workflow. Happy coding!
