package bank.model.product.action;

public class CodeCheck {
	public String prdCode(String code) {
		
		String message = null;		
		if(code.equals("or")){
			return message = "expDay=해당없음, payDay=해당없음";			
		}else if(code.equals("sa")){
			return message = "expDay=해당없음, payDay=해당없음";
		}else if(code.equals("ti")){
			return message = "expDay=기재요망, payDay=해당없음";
		}else{
			return message = "expDay=기재요망, payDay=기재요망";
		}		
	}
}
