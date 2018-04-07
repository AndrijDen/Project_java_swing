package models;

public enum FlowType {
	//��������
	SALARY_MANAGER(1),
	//��������
	EARNINGS_STAFF(2),
	//����������
	REMUNERATION_WORK(3),
	//�������
	COST_STAGE(4);
	
	
	
	private int val;
	
    private FlowType(int val){
        this.val = val;
    }
    
    public int getValue() {
    	return val;
    }
    
}
