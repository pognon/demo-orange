package fr.company.demo.data.dao;

import java.util.List;

import fr.company.demo.data.entity.DemoEntity;
import fr.company.demo.data.entity.nosql.SimpleComment;
import fr.company.demo.data.exception.DAOException;



public interface IDemoDAO {
	
	List<DemoEntity> doSomethingFromDatabase() throws DAOException;
	
	void addCommentToCassandra(SimpleComment comment) throws DAOException;
	
	List<SimpleComment> getCommentsFromCassandra() throws DAOException;

}
