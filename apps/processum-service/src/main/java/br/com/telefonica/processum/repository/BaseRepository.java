package br.com.telefonica.processum.repository;

import java.io.Serializable;
import java.sql.Timestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author ifbomfim
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

  @Query(value = "SELECT SYSDATE AS DATA FROM DUAL", nativeQuery = true)
  public Timestamp getDataAtual();

}
