public class Emp implements Writable{
public int id;
public String name;
public Emp(){
this.id = id;
this.name=name;
}
public void write(DataOutput out) throws IOException {
    out.writeInt(id);
    out.writeUTF(name);
  }
public void readFields(DataInput in) throws IOException {
    id = in.readInt();
    name = in.readUTF();
 }
 public String toString() {
    return id + ", " + name;
 }
}
