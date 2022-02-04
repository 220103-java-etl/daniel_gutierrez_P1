package com.revature.models;

//need to implement this with the form request to show up for the resolver for priority viewing.

public enum Deadline {
     urg {
        @Override
        public String toString() {
            return "Urgent Request";
        }
    },

    stand {
        @Override
        public String toString() {
            return "Standard Request";
        }
    }
}
