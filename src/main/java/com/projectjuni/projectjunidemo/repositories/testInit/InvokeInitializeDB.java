package com.projectjuni.projectjunidemo.repositories.testInit;

public class InvokeInitializeDB {
	public void execute(InitializeDB command) throws Exception{
		command.initialize();
	}

}
