/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author duartemac
 */
@Named
public class ProjectFactory {
    // Project data
    public final static String PROJECT_TITLE = "title";
    public final static String PROJECT_DESCRIPTION = "description";
    
    @Inject
    private ProjectRepository projectRepository;
    
    private Project project(String title, String description) {
        Project project = projectRepository
                .findByTitleAndDescription(title, description);
        
        if (project == null) {
            project = Project.builder()
                .title(title)
                .description(description)
                .build();
            
            this.projectRepository.save(project);
        }
        
        return project;
    }
    
    public Project project() {
        return this.project(PROJECT_TITLE, PROJECT_DESCRIPTION);
    }
}
