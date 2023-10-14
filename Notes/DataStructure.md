# **Data Structures: Introduction**

### **Arrays**

- Ways to initialize array

```
String[] colors = new String[5];
int[] numbers = { 100, 200 };
```

- Adding values and printing

```
String[] colors = new String[5];
colors[0] = "purple";
colors[1] = "blue";
System.out.println(Arrays.toString(colors));
```

- Array index bound exception

```
String[] colors = new String[2];
colors[0] = "purple";
colors[1] = "blue";
System.out.println(colors[0]);
System.out.println(colors[1]);
System.out.println(colors[2]);//Array index bound exception
```

- Looping through

```
for(i=0;i<colors.length;i++)
for (String col : colors)
Arrays.stream(colors).forEach(System.out::println);
```

---

### **2D Arrays**

- Ways to initialize 2D array and print

```
char[][] board = new char[3][3];
for(int i=0; i<3;i++){
   for(int j=0; j<3;j++){
       board[i][j]='-';
   }
}
board[0][0]='0';
System.out.println(Arrays.deepToString(board));

char [][]boardTwo= new char[][]{
   new char[]{'0','-','-'},
   new char[]{'-','-','-'},
   new char[]{'-','-','-'}
};
System.out.println(Arrays.deepToString(boardTwo));
```

---

### **Lists and ArrayList**

- List is an ordered collection.
- It allows duplicates.
- They don't have fixed size.
- Fast for retrievals
- Implementations
  - Array List
  - Stack
  - Vector
  - Others
- Ways to initialize List and print

```
List<String> colors1 = List.of("blue","yellow");//unmodifiable list created
List<String> colors = new ArrayList<String>();
colors.add("blue");
colors.add("purple");
System.out.println(colors.size());
System.out.println(colors.contains("purple"));
System.out.println(colors.contains("pink"));
System.out.println(colors);

for(String col:colors){
    System.out.println(col);
}
colors.forEach(System.out::println);
for(int i=0;i<colors.size();i++){
    System.out.println(colors.get(i));
}
```

---

### **Stack**

- LIFO
- push and pop operations.
- extends vector.
- Ways to initialize Stack and print

```
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.add(9);
stack.push(5);
stack.push(7);
System.out.println(stack.peek());
System.out.println(stack.size());
System.out.println(stack.pop());
System.out.println(stack.size());
```

---

### **Queue**

- FIFO
- This collection is designed for holding elements prior to processing.
- Ways to initialize Queue and print

```
Queue<Person> queue = new LinkedList<>();
queue.add(new Person("Alex", 21));
queue.add(new Person("Sam", 29));
queue.add(new Person("Wally", 43));

System.out.println(queue.size());
System.out.println(queue.peek());
System.out.println(queue.poll());
System.out.println(queue.size());
System.out.println(queue.peek());
```
