package br.com.diegosst.archetype.domain.entity;

public class BaseEntity {

    private String id;

    public BaseEntity() {
    }

    private BaseEntity(Builder builder) {
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class Builder {
        private String id;

        public Builder(String id) {
            this.id = id;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public BaseEntity build() {
            return new BaseEntity(this);
        }
    }

}
