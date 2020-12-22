package bpb;
  import java.io.IOException;
  import org.apache.pig.EvalFunc;
  import org.apache.pig.data.Tuple;

  public class LOWER extends EvalFunc<String>
  {
    public String exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0 || input.get(0) == null)
            return null;
        try{
            String str = (String)input.get(0);
           return str.toLowerCase();
        }catch(Exception e){
            throw new IOException("Caught exception processing input row ", e);
        }
    }
  }
