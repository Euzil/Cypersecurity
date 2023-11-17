import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Provides functionality to parse input test case files.
 */
public class InputFileParser
{
    /**
     * The amount of conflict of interest classes.
     */
    public int CoiCount = 0;

    /**
     * The amount of companies.
     */
    public int CompanyCount = 0;

    /**
     * The amount of subjects.
     */
    public int ObjectCount = 0;

    /**
     * The amount of objects.
     */
    public int SubjectCount = 0;

    /**
     * The company conflict of interest classes. Mapping: companyId => coiId.
     */
    public List<Integer> CompanyCois = new ArrayList<Integer>();

    /**
     * The company of each object. Mapping: objectId => companyId.
     */
    public List<Integer> ObjectCompanies = new ArrayList<Integer>();

    /**
     * A sequence of object access requests by different subjects. List of
     * (subjectId, objectId) pairs.
     */
    public List<ObjectAccessRequest> ObjectAccessRequests = new ArrayList<ObjectAccessRequest>();

    /**
     * Reads the test case data from the given input stream.
     * 
     * @param in
     *            The input stream containing the test case data.
     */
    public InputFileParser(InputStream in)
    {
        // Read input
        try(Scanner sc = new Scanner(in))
        {
            // Read COI count
            CoiCount = sc.nextInt();

            // Read company amount and their COI IDs
            CompanyCount = sc.nextInt();
            for(int i = 0; i < CompanyCount; ++i)
                CompanyCois.add(sc.nextInt());

            // Read object count and their company IDs
            ObjectCount = sc.nextInt();
            for(int i = 0; i < ObjectCount; ++i)
                ObjectCompanies.add(sc.nextInt());

            // Read subject count
            SubjectCount = sc.nextInt();

            // Read object access requests
            int objectAccessRequestCount = sc.nextInt();
            for(int i = 0; i < objectAccessRequestCount; ++i)
                ObjectAccessRequests.add(new ObjectAccessRequest(sc.nextInt(), sc.nextInt()));
        }
    }

    /**
     * Container class for object access requests.
     */
    public class ObjectAccessRequest
    {
        /**
         * The ID of the accessing subject.
         */
        public Integer SubjectId;

        /**
         * The ID of the accessed object.
         */
        public Integer ObjectId;

        /**
         * Creates a new object access request.
         * 
         * @param subjectId
         *            The requesting subject.
         * @param objectId
         *            The accessed object.
         */
        public ObjectAccessRequest(Integer subjectId, Integer objectId)
        {
            // Save parameters
            SubjectId = subjectId;
            ObjectId = objectId;
        }
    }
}
