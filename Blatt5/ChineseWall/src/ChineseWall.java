public class ChineseWall
{
    /**
     * Contains the current test case data.
     */
    static InputFileParser _testcaseParser;

    /**
     * Program entry point.
     * 
     * @param args
     *            Ignored.
     */
    public static void main(String[] args)
    {
        // Read test case from stdin
        _testcaseParser = new InputFileParser(System.in);

        /* ************************************** */
        /* TODO Add optional initializations here */
        /* ************************************** */
		
		// NOTE Be careful with integer comparisons:
		//      The "==" operator only works with variables of type "int", use Integer.equals for all others

        // Run through access requests and check each of them
        boolean denied = false;
        for(InputFileParser.ObjectAccessRequest objectAccessRequest : _testcaseParser.ObjectAccessRequests)
        {
            // Access denied?
            if(!handleAccessRequest(objectAccessRequest.SubjectId, objectAccessRequest.ObjectId))
            {
                System.out.println("Access denied for request (" + objectAccessRequest.SubjectId + ", " + objectAccessRequest.ObjectId + ")");
                denied = true;
            }
        }
        if(!denied)
            System.out.println("All access requests were granted!");
    }

    /**
     * Checks the given object access requests and returns whether it is granted or
     * not; this method also keeps track of past object accesses.
     * 
     * @param subjectId
     *            The ID of the subject requesting the object access.
     * @param objectId
     *            The object being accessed.
     * @return Whether the object access is granted or denied.
     */
    public static boolean handleAccessRequest(Integer subjectId, Integer objectId)
    {
        /* *************************************** */
        /* TODO Add access request processing here */
        /* *************************************** */
        return true;
    }
}
