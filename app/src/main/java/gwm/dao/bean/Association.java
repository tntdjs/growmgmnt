package gwm.dao.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "Association" )
public class Association implements Serializable {

	private static final long serialVersionUID = 6874761658192655794L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	 @Column(name = "name")
	private String name;
	
	public Association() {
		
	}
	
	public Association(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
		return id;
    }
	
    @SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
    }
    
    public String getName() {
		return name;
    }

    public void setName(String name) {
		this.name = name;
    }
    
    public String toString() {
    	return "ID=" + this.id + ", Name=" + this.name;
    }
}
