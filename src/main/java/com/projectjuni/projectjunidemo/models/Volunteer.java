package com.projectjuni.projectjunidemo.models;

import java.util.UUID;

public interface Volunteer {

	public UUID getUser_id();

	public void setUser_id(UUID user_id);

	public String getFirst_name();

	public void setFirst_name(String first_name);

	public String getLast_name();

	public void setLast_name(String last_name);
}
