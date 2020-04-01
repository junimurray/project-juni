package com.projectjuni.projectjunidemo.testInit;

public class InvokeInitializeDB {
	public void execute(InitializeDB command) throws Exception{
		command.initialize();
	}

}
