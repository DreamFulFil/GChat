package dream.free.sideproject.cowork.gchat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "INFORMATION_NODE")
@Data
public class NodeInformation {

    /** 流水號*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /** 來源節點識別碼(唯一值)*/
    @Column(name = "NODE_ID")
    private int nodeId;
    
    /** 資訊內容(文字、影片…)*/
    @Column(name = "INFORMATION_BODY")
    private byte[] informationBody;
    
    /** 建立時間*/
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;
 
    /** 最後修改時間*/
    @Column(name = "MODIFIED_DATE")
    @LastModifiedDate
    private long modifiedDate;

}
