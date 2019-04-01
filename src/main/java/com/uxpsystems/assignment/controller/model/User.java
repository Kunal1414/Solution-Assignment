
package com.uxpsystems.assignment.controller.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxpsystems.assignment.util.PasswordUtil;

@Entity
@Table(name = "user")
public class User implements Serializable
{

    final static long serialVersionUID = 8941405040585205546L;
    
    @Id
    @Column(name = "userId ", nullable = false, unique = true)
    private Long userId;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Column
	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @Column
	@Enumerated(EnumType.STRING)
    private IdentifierforUserstatus status;

    /**
     * Creates a new User.
     * 
     */
    public User() {
        super();
    }

    /**
     * Creates a new User.
     * 
     */
    public User(Long userId, String name, String password, IdentifierforUserstatus status) {
        super();
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.status = status;
    }
    
    
    public User(String name, String password, IdentifierforUserstatus status) {
        super();
        this.name = name;
        this.password = password;
        this.status = status;
    }

    /**
     * Returns the userId.
     * 
     * @return
     *     userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Set the userId.
     * 
     * @param userId
     *     the new userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Returns the name.
     * 
     * @return
     *     name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * 
     * @param name
     *     the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the password.
     * 
     * @return
     *     password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password.
     * 
     * @param password
     *     the new password
     */
    public void setPassword(String password) {
    	this.password = PasswordUtil.instance.getPasswordEncoder().encode(password);
    }

    /**
     * Returns the status.
     * 
     * @return
     *     status
     */
    public IdentifierforUserstatus getStatus() {
        return status;
    }

    /**
     * Set the status.
     * 
     * @param status
     *     the new status
     */
    public void setStatus(IdentifierforUserstatus status) {
        this.status = status;
    }

   

    public String toString() {
        return new ToStringBuilder(this).append("userId", userId).append("name", name).append("password", password).append("status", status).toString();
    }

}
