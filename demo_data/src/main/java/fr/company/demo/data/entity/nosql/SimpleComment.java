package fr.company.demo.data.entity.nosql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="SIMPLE_COMMENT", schema="KunderaExamples@cassandra_pu")
@XmlRootElement(name = "SimpleComment")
public class SimpleComment
{
    @Id
    @Column(name = "COMMENT_ID")
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "COMMENT_TEXT")
    private String commentText;

    public SimpleComment() {
    }    
    public SimpleComment(int commentId, String userName, String commentText) {
        this.id = commentId;
        this.userName = userName;
        this.commentText = commentText;
    }      
    public int getId()
    {
        return id;
    }   
    public void setId(int id)
    {
        this.id = id;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getCommentText()
    {
        return commentText;
    }
    public void setCommentText(String commentText)
    {
        this.commentText = commentText;
    }
}