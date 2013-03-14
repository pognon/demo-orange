package fr.company.demo.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.company.demo.data.dao.IDemoDAO;
import fr.company.demo.data.entity.DemoEntity;
import fr.company.demo.data.entity.nosql.SimpleComment;
import fr.company.demo.data.exception.DAOException;

@Repository
public class DemoDAO extends AbstractJpaDAO<DemoEntity> implements IDemoDAO {

	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(DemoDAO.class);

	public DemoDAO() {
		setClazz(DemoEntity.class);
	}

	@SuppressWarnings("unchecked")
	public List<DemoEntity> doSomethingFromDatabase() throws DAOException {
		LOG.info("Service method doSomethingFromDatabase is calling...");
		return (List<DemoEntity>) entityManager.createQuery("from DemoEntity")
				.getResultList();
	}

	public void addCommentToCassandra(SimpleComment comment)
			throws DAOException {
		entityManager.persist(comment);
	}

	public List<SimpleComment> getCommentsFromCassandra() throws DAOException {
		// return (SimpleComment)entityManager.find(SimpleComment.class, 1);
		// return
		// (SimpleComment)entityManager.createQuery("select s from SimpleComment s").getSingleResult();

		Query q = entityManager.createQuery("select p from SimpleComment p");
		List<SimpleComment> comments = (List<SimpleComment>)q.getResultList();

		LOG.info("The number of comments is : " + comments.size());

		return comments;

	}

}
