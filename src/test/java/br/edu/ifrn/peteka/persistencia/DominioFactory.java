package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.dominio.User;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author duartemac
 */
@Named
public class DominioFactory {
    // Project data
    private final String PROJECT_TITLE = "title";
    private final String PROJECT_DESCRIPTION = "description";

    // Role data
    private final String ROLE_TITLE = "title";
    private final String ROLE_TITLE2 = "title1";

    // Status data
    private final String STATUS_LABEL = "label";
    private final String STATUS_LABEL2 = "label2";
    
    // Task data
    private final String TASK_TITLE = "title";
    private final String TASK_DESCRIPTION = "D1";
    
    // User data
    private final String USER_NICKNAME = "nickname";
    private final String USER_NICKNAME2 = "nickname2";
    private final String USER_NAME = "nome";

    // Repositories
    @Inject
    private ProjectRepository projectRepository;

    @Inject
    private RoleRepository roleRepository;
    
    @Inject
    private StatusRepository statusRepository;
    
    @Inject
    private TaskRepository taskRepository;
    
    @Inject
    private UserRepository userRepository;
    
    public String getROLE_TITLE() {
        return ROLE_TITLE;
    }

    public String getROLE_TITLE2() {
        return ROLE_TITLE2;
    }

    public String getSTATUS_LABEL() {
        return STATUS_LABEL;
    }

    public String getSTATUS_LABEL2() {
        return STATUS_LABEL2;
    }
    
    
    
    public Project project() {
        Project project = Project.builder()
                .title(this.PROJECT_TITLE)
                .description(this.PROJECT_DESCRIPTION)
                .build();
        
        this.projectRepository.save(project);
        
        return project;
    }
    
    public User user() {
        User user = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME)
                .build();
        
        this.userRepository.save(user);
        
        return user;
    }
    public User user(Role r) {
        User user = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME)
                .role(r)
                .build();
        
        this.userRepository.save(user);
        
        return user;
    }
    
    public Role role() {
        Role role = Role.builder()
                .title(this.ROLE_TITLE)
                .build();
        
        this.roleRepository.save(role);
        
        return role;
    }
    
    public Role role2() {
        Role role = Role.builder()
                .title(this.ROLE_TITLE2)
                .build();
        
        this.roleRepository.save(role);
        
        return role;
    }
    
    public Status status() {
        Status status = Status.builder()
                .label(this.STATUS_LABEL)
                .build();

        this.statusRepository.save(status);

        return status;
    }
    
    public Status status2() {
        Status status = Status.builder()
                .label(this.STATUS_LABEL2)
                .build();

        this.statusRepository.save(status);

        return status;
    }
    
    public Task task() {
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION).build();

        this.taskRepository.save(task);

        return task;
    }
    
    public Task task(Status st) {
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION)
                .status(st)
                .build();
        
        this.taskRepository.save(task);
        
        return task;
    }
    
    public Task task(Project p) {
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION)
                .project(p)
                .build();
        
        this.taskRepository.save(task);
        
        return task;
    }
    
    public Task task(Project p, Status st) {
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION)
                .project(p)
                .status(st)
                .build();
        
        this.taskRepository.save(task);
        
        return task;
    }
    
    public Task task(Project p, User u) {
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION)
                .project(p)
                .assignee(u)
                .build();
        
        this.taskRepository.save(task);
        
        return task;
    }
}
