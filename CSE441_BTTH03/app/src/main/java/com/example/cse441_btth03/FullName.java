package com.example.cse441_btth03;

public class FullName {
        private String first_name;
        private String middle_name;
        private String last_name;

        public FullName(String first_name, String last_name, String middle_name) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.middle_name = middle_name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getMiddle_name() {
            return middle_name;
        }
    }

