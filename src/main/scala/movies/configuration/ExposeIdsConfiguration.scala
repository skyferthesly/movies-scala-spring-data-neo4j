package movies

import org.springframework.stereotype.Component
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import org.springframework.data.rest.core.config.RepositoryRestConfiguration

//@Component
class ExposeIdsConfiguration extends RepositoryRestConfigurerAdapter {
  override def configureRepositoryRestConfiguration(config: RepositoryRestConfiguration): Unit = config.exposeIdsFor(classOf[Movie])
  
}