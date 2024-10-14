package com.solvd.enums;

public enum JobPositions {
    MANAGER("Manage"),
    CASHIER("Cashier"),
    SECURITY_GUARD("securityGuard");

    final String jobPosition;

    JobPositions(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobPosition() {
        return jobPosition;
    }
}
