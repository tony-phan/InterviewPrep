# Int

### Maximum & Minimum values of int

int.MaxValue = 2147483647  
int.MinValue = -2147483648  
int x = int.MinValue;

### Convert string to int

int num = int.Parse("500");

# Array & List

### Convert array to list

List<string> list = array.ToList();  
OR  
List<string> list = new List<string>(array);

### Convert list to array

int[] a = list.ToArray();

### Fill an array with values

string[] a = new string[10];  
Array.Fill(a, "a");

### Concatenate all items of array/list into a string

var fruits = new List<string> { "Apple", "Banana", "Cherry" };

string s = string.Join(", ", fruits); // "Apple, Banana, Cherry"

# Dictionary

### Check if a key exists

Dictionary<int, int> dict = new Dictionary<int, int>();

dict.ContainsKey(0);

### Looping through a dictionary

Dictionary<int,int> dp = new Dictionary<int,int>();

foreach(KeyValuePair<int, int> a in dp) {
Console.WriteLine($"Key: {a.Key} -> Value: {a.Value}");
}
