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
    public final static String PROJECT_TITLE = "title";
    public final static String PROJECT_DESCRIPTION = "description";

    // Role data
    public final static String ROLE_TITLE = "title";
    public final static String ROLE_TITLE2 = "title1";

    // Status data
    public final static String STATUS_LABEL = "label";
    public final static String STATUS_LABEL2 = "label2";
    
    // Task data
    public final static String TASK_TITLE = "title";
    public final static String TASK_DESCRIPTION = "D1";
    
    // User data
    public final static String USER_NICKNAME = "nickname";
    public final static String USER_NICKNAME2 = "nickname2";
    public final static String USER_NAME = "nome";

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
                .title(PROJECT_TITLE)
                .description(PROJECT_DESCRIPTION)
                .build();
        
        this.projectRepository.save(project);
        
        return project;
    }
    
    public User user() {
        Role r = this.role();
        User user = User.builder()
                .nickname(USER_NICKNAME)
                .name(USER_NAME)
                .role(r)
                .build();
        
        this.userRepository.save(user);
        
        return user;
    }
    public User user(Role r) {
        User user = User.builder()
                .nickname(USER_NICKNAME)
                .name(USER_NAME)
                .role(r)
                .build();
        
        this.userRepository.save(user);
        
        return user;
    }
    
    public Role role() {
        Role role = Role.builder()
                .title(ROLE_TITLE)
                .build();
        
        this.roleRepository.save(role);
        
        return role;
    }
    
    public Role role2() {
        Role role = Role.builder()
                .title(ROLE_TITLE2)
                .build();
        
        this.roleRepository.save(role);
        
        return role;
    }
    
    public Status status() {
        Status status = Status.builder()
                .label(STATUS_LABEL)
                .build();

        this.statusRepository.save(status);

        return status;
    }
    
    public Status status2() {
        Status status = Status.builder()
                .label(STATUS_LABEL2)
                .build();

        this.statusRepository.save(status);

        return status;
    }
    
    public Task task() {
        Status st = this.status();
        Project p = this.project();
        Task task = Task.builder()
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .status(st)
                .project(p)
                .build();

        this.taskRepository.save(task);

        return task;
    }
    
    public Task task(Status st) {
        Project p = this.project();
        Task task = Task.builder()
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .status(st)
                .project(p)
                .build();
        
        this.taskRepository.save(task);
        
        return task;
    }
    
    public Task task(Project p) {
        Status st = this.status();
        Task task = Task.builder()
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .project(p)
                .status(st)
                .build();
        
        this.taskRepository.save(task);
        
        return task;
    }
    
    public Task task(Project p, Status st) {
        Task task = Task.builder()
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .project(p)
                .status(st)
                .build();
        
        this.taskRepository.save(task);
        
        return task;
    }
    
    public Task task(Project p, User u) {
        Status st = this.status();
        Task task = Task.builder()
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .project(p)
                .status(st)
                .assignee(u)
                .build();
        
        this.taskRepository.save(task);
        
        return task;
    }
}
