package campus.service;
import campus.enums.ResourceType;
import campus.model.Resource;
import java.util.ArrayList;
import java.util.List;
public class ResourceService {
    private final List<Resource> resources = new ArrayList<>();
    public void addResource(Resource resource) {
        resources.add(resource);
        System.out.println("Resource added successfully.");
    }
    public Resource findResourceById(int resourceId) {
        for (Resource resource : resources) {
            if (resource.getResourceId() == resourceId) {
                return resource;
            }
        }
        return null;
    }
    public List<Resource> searchByType(ResourceType type) {
        List<Resource> result = new ArrayList<>();
        for (Resource resource : resources) {
            if (resource.getResourceType() == type
                    && resource.isAvailable()) {
                result.add(resource);
            }
        }
        return result;
    }
    public void displayAvailableResources() {
        boolean found = false;
        for (Resource resource : resources) {
            if (resource.isAvailable()) {
                resource.displayResourceInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No resources are currently available.");
        }
    }
    public List<Resource> getResources() {
        return resources;
    }
}
