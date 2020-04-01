package com.projectjuni.projectjunidemo.models.committees;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "def")
public class DefaultCommittee extends Committee {

}
