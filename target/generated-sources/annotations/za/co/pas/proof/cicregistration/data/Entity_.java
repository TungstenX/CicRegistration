package za.co.pas.proof.cicregistration.data;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Entity.class)
public abstract class Entity_ {

	public static volatile SingularAttribute<Entity, String> emailAddress;
	public static volatile SingularAttribute<Entity, String> entityName;
	public static volatile SingularAttribute<Entity, Integer> entityId;
	public static volatile CollectionAttribute<Entity, Cic> cicCollection;

}

