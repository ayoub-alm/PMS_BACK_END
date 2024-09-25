package ma.achat.achats_back.service.data;

import jakarta.persistence.EntityNotFoundException;
import ma.achat.achats_back.entity.data.ProjectType;
import ma.achat.achats_back.repository.data.ProjectTypeRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeService {
    private final ProjectTypeRepository projectTypeRepository;

    public ProjectTypeService(ProjectTypeRepository projectTypeRepository) {
        this.projectTypeRepository = projectTypeRepository;
    }

    /**
     * Retrieves all project types from the repository.
     *
     * @return a list of all project types.
     */
    public List<ProjectType> getAllProjectTypes() {
        return projectTypeRepository.findAll();
    }

    /**
     * Retrieves a project type by its ID.
     *
     * @param id the ID of the project type to retrieve.
     * @return an Optional containing the project type if found, or empty if not found.
     */
    public Optional<ProjectType> getProjectTypeById(Long id) {
        return this.projectTypeRepository.findById(id);
    }

    /**
     * Adds a new project type to the repository.
     *
     * @param projectType the project type to add.
     * @return the added project type.
     */
    public ProjectType addProjectType(ProjectType projectType) {
        return this.projectTypeRepository.save(projectType);
    }

    /**
     * Updates an existing project type by its ID.
     *
     * @param id          the ID of the project type to update.
     * @param projectType the project type data to update.
     * @return the updated project type.
     * @throws EntityNotFoundException if no project type with the specified ID exists.
     */
    public ProjectType updateProjectType(Long id, ProjectType projectType) {
        return this.projectTypeRepository.findById(id)
                .map(existingProjectType -> {
                    existingProjectType.setName(projectType.getName());
                    return this.projectTypeRepository.save(existingProjectType);
                })
                .orElseThrow(() -> new EntityNotFoundException("Project type with id " + id + " not found."));
    }

    /**
     * Deletes a project type by its ID.
     *
     * @param id the ID of the project type to delete.
     * @throws EntityNotFoundException if no project type with the specified ID exists.
     * @throws RuntimeException if there is a failure in deleting the project type.
     */
    public void deleteProjectType(Long id) {
        try {
            this.projectTypeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Project type with id " + id + " not found.", e);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete project type with id " + id, e);
        }
    }
}
