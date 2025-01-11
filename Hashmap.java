// Hash map code here in java is implemented by hashtable
// map<Integer,Integer> myMap = new TreeMap<>();  this stores key in sorted order
Hashmap -> Hashtable (no sorted order)
TreeMap -> BST binery search tree (sorted order)
LinkedHashMap -> Key order depends on insersention
time complexity is O(1)



map<Integer,Integer> myMap = new HashMap<>();

myMap.put(1, 10);
myMap.put(2, 20);
myMap.put(3, 30);

for(Integer key: myMap.keySet())
{
	System.out.println("key: " + key +"value: "+ myMap.get(key));
}

myMap.remove(2);
myMap.clear();
myMap.size();


map<Integer,Integer> m = new HashMap<>();
for (int num : arr)
{
	if(m.containsKey(num))
	{
		m.put(num, m.get(num)+1);
	}
	else 	m.put(num,1);
}

for (Integer key : m.keySet())
{
	System.out.println("key: "+key+ "value: "+ m.get(key));
}