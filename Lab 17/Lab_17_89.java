
import java.util.LinkedList;
import java.util.Scanner;


class KeyValuePair<K, V> {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class HashTable<K, V> {
    private LinkedList<KeyValuePair<K, V>>[] table;
    private int capacity;

    @SuppressWarnings("unchecked")  
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = (LinkedList<KeyValuePair<K, V>>[]) new LinkedList[capacity];  // Safe unchecked cast

      
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }


    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<KeyValuePair<K, V>> bucket = table[index];

        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);  
                return;
            }
        }

       
        bucket.add(new KeyValuePair<>(key, value));
    }

   
    public V get(K key) {
        int index = hash(key);
        LinkedList<KeyValuePair<K, V>> bucket = table[index];

       
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();  
            }
        }
        return null; 
    }

    
    public void remove(K key) {
        int index = hash(key);
        LinkedList<KeyValuePair<K, V>> bucket = table[index];

       
        for (KeyValuePair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                bucket.remove(pair);  
                return;
            }
        }
    }
}


public class Lab_17_89 {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an operation:");
            System.out.println("1: Insert (put) key-value pair");
            System.out.println("2: Retrieve (get) value by key");
            System.out.println("3: Remove key-value pair");
            System.out.println("4: Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    
                    System.out.println("Enter key (string): ");
                    String keyPut = scanner.nextLine();
                    System.out.println("Enter value (integer): ");
                    int valuePut = scanner.nextInt();
                    hashTable.put(keyPut, valuePut);
                    System.out.println("Inserted key-value pair (" + keyPut + ", " + valuePut + ")");
                    break;

                case 2:
                    
                    System.out.println("Enter key (string) to retrieve value: ");
                    String keyGet = scanner.nextLine();
                    Integer valueGet = hashTable.get(keyGet);
                    if (valueGet != null) {
                        System.out.println("Value for key '" + keyGet + "' is: " + valueGet);
                    } else {
                        System.out.println("Key '" + keyGet + "' not found.");
                    }
                    break;

                case 3:
                   
                    System.out.println("Enter key (string) to remove: ");
                    String keyRemove = scanner.nextLine();
                    hashTable.remove(keyRemove);
                    System.out.println("Removed key '" + keyRemove + "'");
                    break;

                case 4:
                    
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
