package models;

public enum FlowType {
	//зарплата
	SALARY_MANAGER(1),
	//заробіток
	EARNINGS_STAFF(2),
	//винагорода
	REMUNERATION_WORK(3),
	//вартість
	COST_STAGE(4);
	
	
	
	private int val;
	
    private FlowType(int val){
        this.val = val;
    }
    
    public int getValue() {
    	return val;
    }
    
}
