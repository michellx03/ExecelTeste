/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsu", query = "SELECT u FROM Usuario u WHERE u.idUsu = :idUsu"),
    @NamedQuery(name = "Usuario.findByNomeUsu", query = "SELECT u FROM Usuario u WHERE u.nomeUsu = :nomeUsu"),
    @NamedQuery(name = "Usuario.findByIdadeUsu", query = "SELECT u FROM Usuario u WHERE u.idadeUsu = :idadeUsu")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usu")
    private Integer idUsu;
    @Column(name = "nome_usu")
    private String nomeUsu;
    @Column(name = "idade_usu")
    private Integer idadeUsu;

    public Usuario() {
    }

    public Usuario(Integer idUsu) {
        this.idUsu = idUsu;
    }

    public Integer getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Integer idUsu) {
        this.idUsu = idUsu;
    }

    public String getNomeUsu() {
        return nomeUsu;
    }

    public void setNomeUsu(String nomeUsu) {
        this.nomeUsu = nomeUsu;
    }

    public Integer getIdadeUsu() {
        return idadeUsu;
    }

    public void setIdadeUsu(Integer idadeUsu) {
        this.idadeUsu = idadeUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsu != null ? idUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsu == null && other.idUsu != null) || (this.idUsu != null && !this.idUsu.equals(other.idUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuario[ idUsu=" + idUsu + " ]";
    }
    
}
