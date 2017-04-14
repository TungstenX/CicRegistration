package za.co.pas.proof.cicregistration.data;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cic.class)
public abstract class Cic_ {

	public static volatile CollectionAttribute<Cic, Entity> entityCollection;
	public static volatile SingularAttribute<Cic, String> subject;
	public static volatile SingularAttribute<Cic, String> sourceSystem;
	public static volatile SingularAttribute<Cic, String> cicType;
	public static volatile SingularAttribute<Cic, Date> cicTimestamp;
	public static volatile SingularAttribute<Cic, Integer> cicid;
	public static volatile SingularAttribute<Cic, String> body;

}

