package payroll.core;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UnionAffiliation extends Affiliation {
    private final int memberId;
    private final double dues;
    private Map<LocalDate, ServiceCharge> serviceChargeMap = new HashMap<>();

    public UnionAffiliation(int memberId, double duesAmount) {
        this.memberId = memberId;
        this.dues = duesAmount;
    }

    public int getMemberId() {
        return memberId;
    }

    public void addServiceCharge(ServiceCharge serviceCharge) {
        serviceChargeMap.put(serviceCharge.getDate(), serviceCharge);
    }
    
    public ServiceCharge getServiceChange(LocalDate date) {
        return serviceChargeMap.get(date);
    }
}
