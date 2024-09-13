package com.solvd.enums;

public enum BranchNames {

    DOWNTOWN_BRANCH("Downtown Branch"),
    CENTRAL_BRANCH("Central Branch"),
    SOMETHINGELSEBRANCH("Somehing Else Branch");

    private final String branchName;

    BranchNames(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }
}
