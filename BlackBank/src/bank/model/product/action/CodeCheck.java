package bank.model.product.action;

public class CodeCheck {
	public String prdCode(String code) {
		
		String message = null;		
		if(code.equals("or")){
			return message = "expDay=�ش����, payDay=�ش����";			
		}else if(code.equals("sa")){
			return message = "expDay=�ش����, payDay=�ش����";
		}else if(code.equals("ti")){
			return message = "expDay=������, payDay=�ش����";
		}else{
			return message = "expDay=������, payDay=������";
		}		
	}
}
