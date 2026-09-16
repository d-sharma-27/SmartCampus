package campus.model;
import campus.enums.ResourceType;
public class Resource {
    private int resourceId;
    private String resourceName;
    private ResourceType resourceType;
    private String location;
    private int capacity;
    private boolean available;
    public Resource(int resourceId, String resourceName,
                    ResourceType resourceType, String location,
                    int capacity) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.location = location;
        this.capacity = capacity;
        this.available = true;
    }
    public int getResourceId() {
        return resourceId;
    }
    public String getResourceName() {
        return resourceName;
    }
    public ResourceType getResourceType() {
        return resourceType;
    }
    public String getLocation() {
        return location;
    }
    public int getCapacity() {
        return capacity;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void displayResourceInfo() {
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Resource Name: " + resourceName);
        System.out.println("Type: " + resourceType);
        System.out.println("Location: " + location);
        System.out.println("Capacity: " + capacity);
        System.out.println("Available: " + available);
    }
}
