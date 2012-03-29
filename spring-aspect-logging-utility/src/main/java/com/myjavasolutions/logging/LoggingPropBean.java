package com.myjavasolutions.logging;

public class LoggingPropBean {
	
	private Class className;
	private String methodSignature;
	private String returnValue;
	private Object[] arguments;
	private String state;
	
	public Class getClassName() {
		return className;
	}
	public void setClassName(Class className) {
		this.className = className;
	}
	public String getMethodSignature() {
		return methodSignature;
	}
	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}
	public String getReturnValue() {
		return returnValue;
	}
	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}
	public Object[] getArguments() {
		return arguments;
	}
	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		Object[] passedArgs = this.getArguments();
		String state = this.getState();
		
		result.append(state + " --> ");
		result.append(this.getMethodSignature());
		
		if(state.equalsIgnoreCase("entering")) {
			int argLength = passedArgs.length;
			
			if(argLength > 0) {
				result.append("Arguments Passed: ");
			}
			
			for(int i = 0; i < argLength; i++) {
				result.append(passedArgs[i]);
				if(i < (passedArgs.length - 1)) {
					result.append(",");
				}
				
			}
		}
		if(state.equalsIgnoreCase("exiting")) {
			result.append("Returned Value:");
			result.append(this.getReturnValue());
		}
		return result.toString();
	}
	
	public void reset() {
		
		this.setClassName(null);
		this.setState("");
		this.setMethodSignature("");
		this.setReturnValue("");
		this.setArguments(null);
		
	}
	
	

}
