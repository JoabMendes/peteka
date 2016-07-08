package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Users;
import br.edu.ifrn.peteka.persistencia.ProjectRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;


@Named
public class ProjectService extends AbstractService<Project, Long> {
    private ProjectRepository projectRepository;

    @Inject
    public ProjectService(ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
    }
    
    public List<Project> getAllProjectsOfUser(Users u) {
        return this.projectRepository.getAllProjectsOfUser(u);
    } 
}
