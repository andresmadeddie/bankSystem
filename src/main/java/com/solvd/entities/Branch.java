package main.java.com.solvd.entities;

import java.util.Objects;

public final class Branch {
    static final String bankName;

    static {
        bankName = "BankMine";
    }
    private String branchId;
    private String branchName;
    private String address;

    public Branch(String branchId, String branchName, String address) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.address = address;
    }

    public final String getBankName(){
        return bankName;
    }
    @Override
    public String toString() {
        return "branchId=" + branchId + ", branchName=" + branchName + ", address=" + address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Branch branch = (Branch) obj;
        return branchId.equals(branch.branchId) &&
                branchName.equals(branch.branchName) &&
                address.equals(branch.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, branchName, address);
    }
}
