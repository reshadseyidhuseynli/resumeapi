package com.company.entity;

import com.company.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-25T01:20:58")
@StaticMetamodel(EmploymentHistory.class)
public class EmploymentHistory_ { 

    public static volatile SingularAttribute<EmploymentHistory, Date> beginDate;
    public static volatile SingularAttribute<EmploymentHistory, Date> endDate;
    public static volatile SingularAttribute<EmploymentHistory, String> header;
    public static volatile SingularAttribute<EmploymentHistory, String> description;
    public static volatile SingularAttribute<EmploymentHistory, Integer> id;
    public static volatile SingularAttribute<EmploymentHistory, User> user;

}