//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.29 at 02:19:47 PM PDT 
//


package com.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}EMPNO"/>
 *         &lt;element ref="{}FIRSTNAME"/>
 *         &lt;element ref="{}LASTNAME"/>
 *         &lt;element ref="{}CACHE_UPDATED_AT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "empno",
    "firstname",
    "lastname",
    "cacheupdatedat"
})
@XmlRootElement(name = "EMPLOYEE")
public class EMPLOYEE {

    @XmlElement(name = "EMPNO")
    protected int empno;
    @XmlElement(name = "FIRSTNAME", required = true)
    protected String firstname;
    @XmlElement(name = "LASTNAME", required = true)
    protected String lastname;
    @XmlElement(name = "CACHE_UPDATED_AT", required = true)
    protected String cacheupdatedat;

    /**
     * Gets the value of the empno property.
     * 
     */
    public int getEMPNO() {
        return empno;
    }

    /**
     * Sets the value of the empno property.
     * 
     */
    public void setEMPNO(int value) {
        this.empno = value;
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIRSTNAME() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIRSTNAME(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTNAME() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTNAME(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the cacheupdatedat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCACHEUPDATEDAT() {
        return cacheupdatedat;
    }

    /**
     * Sets the value of the cacheupdatedat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCACHEUPDATEDAT(String value) {
        this.cacheupdatedat = value;
    }

}
