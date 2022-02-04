package com.revature.models;
//enum for reimbursement options go here d
//place here so that your requests class can call on this for form use
//use this for the reimbursement math portion to  make sure employees only get so much paid for.

public enum Selection {

        uniCourse{
            @Override
            public String toString() {
                return "University Course";
            }
        },
        seminars {
            @Override
            public String toString() {
                return "Seminar";
            }
        },
        certPrep{
            @Override
            public String toString() {
                return "Certification Prep";
            }
        },
        cert{
            @Override
            public String toString() {
                return "Certification";
            }

        },
        techTraining {
            @Override
            public String toString() {
                return "Technical Training";
            }
        },
        other {
            @Override
            public String toString() {
                return "Other";
            }
        }



    }

