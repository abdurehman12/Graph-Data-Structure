public class MyGraph {
    vertex[] adjList;
    int count;

    MyGraph(int s) {
        adjList = new vertex[s];
        count = 0;
    }

    public void AddVertex(String n, int a) {
        // add person name and age…
    vertex newVertex= new vertex(n,a);
    if(count<adjList.length){
        adjList[count]=newVertex;
        count++;
    }
        else
    {
        System.out.println("The list is full");
    }
    }

    public void AddEdge(String n1, String n2) {// add an edge between two person
    int vertex_1=0;
    int vertex_2=0;
        for (int i=0;i<adjList.length-1;i++){
        if(adjList[i].name==n1){
             vertex_1=i;
        }
        if(adjList[i].name==n2){
             vertex_2=i;
        }
    }
        adjList[vertex_1].friendsList.insert(adjList[vertex_2]);
        adjList[vertex_2].friendsList.insert(adjList[vertex_1]);
    }

    public void DFS(MyGraph G, String n) {  // print all person in DFS sequence,
        //      use stack that you implement earlier
        vertex s = G.FindVertex(n);
        if(G.count!=-1 && G.FindVertex(n)!=null){
            LinkedListStack<vertex> stack = new LinkedListStack<>();
            Boolean[] Visited = new Boolean[G.count+1];
            for(int i=0; i<Visited.length; i++){
                Visited[i]=false;
            }
            stack.PUSH(s);
            Visited[G.FindIndex(n)]=true;
            System.out.println(s);
            int unvisited = count;
            vertex v;
            vertex w;
            while(unvisited>0){
                while(!stack.isEmpty()){
                    v = stack.POP();
                    w=null;
                    for(int i=0; i<Visited.length;i++){
                        if(v.friendsList.Find(G.adjList[i]) && Visited[i]==false){
                            w= G.adjList[i];
                            break;
                        }
                    }
                    if(w!=null){
                        stack.PUSH(w);
                        Visited[G.FindIndex(w.name)]=true;
                        System.out.println( w);
                        unvisited--;
                    }
                    else{
                        stack.POP();
                    }
                }
                v=null;
                for(int i=0; i<Visited.length;i++){
                    if(Visited[i]==false){
                        v=G.adjList[i];
                        break;
                    }
                }
                if(v!=null){
                    stack.PUSH(v);
                    Visited[G.FindIndex(v.name)]=true;
                    unvisited--;
                    System.out.println(v);
                }
                else{
                    break;
                }
            }
        }

    }

    public void deleteVertex(String n) { // delete a person

    for (int i=0;i<adjList.length;i++){
      if(adjList[i].name==n){
          adjList[i]=null;
          break;
      }
    }

    }

    public void deleteEdge(String n1, String n2) { // delete friend’s relation by
       // removing an edge between two person
        vertex vertex_1=FindVertex(n1);
        vertex vertex_2=FindVertex(n2);
        vertex_1.friendsList.delete(vertex_2);
        vertex_2.friendsList.delete(vertex_1);

    }
         public vertex FindVertex(String n){  // find a person
        for(int i=0;i<adjList.length;i++){
            if(adjList[i].name==n){
                return adjList[i];
            }
        }
        return null;
    }

    public int FindIndex(String n){ // find a person
        for(int i=0; i<=count;i++){
            if(adjList[i].name.equalsIgnoreCase(n)){
                return i;
            }
        }
        return -1;
    }
        public String toString(){ // list all person and their friend’s relationship
        String s="";
        for(int i=0;i <= adjList.length;i++){
            if (adjList[i].name!=null) {
                s = s + adjList[i].name + "  " + adjList[i].friendsList.toString() + "\n";
            }
        }
        return s;
    }

         }


