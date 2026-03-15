**These roles are typically 60 minutes total: **
quick warm-up 

Java/Spring questions (5–10 mins), 
**live coding (often 2 medium problems in 25–30 mins), **
OOP/design/debugging (10 mins), and 
**light system design/scenarios (10 mins). **
Focus is on practical Java/backend skills, verbal explanation, and efficiency.

**1. Core Java & Internals (Quick verbal questions, 5–10 mins)**
•  Explain internal working of ConcurrentHashMap (segmentation, locking, Java 8 changes).
•  HashMap vs ConcurrentHashMap (collisions, thread-safety, performance).
•  Java 8 features: Streams, lambdas, Optional—when to use, pros/cons.
•  Principles to follow while coding (SOLID, clean code basics).
•  Multithreading basics: synchronized vs ReentrantLock, volatile, thread pools.
•  Collections: When to use ArrayList vs LinkedList, HashSet internals.

**2. Spring/Spring Boot & Frameworks (Scenario-based, 5–10 questions rapid-fire)**
•  Spring Boot vs Spring MVC differences.
•  Dependency injection in Spring—how it works, @Autowired internals.
•  Spring Boot controller and service layer—design a simple one (e.g., fix or build endpoints).
•  Microservices basics: How to design/communicate (REST, Kafka integration often mentioned).
•  Scenario: Handle a banking API with high load—caching, transactions.
•  Common: Fix bugs in predefined Spring code snippets (null pointers in controllers, etc.).

**3. Coding / DSA (Live coding, usually 2 mediums in 25–30 mins, timed tight)**
•  Two Sum — Array of integers, find indices that sum to target (HashMap O(n) solution mandatory).
•  Word Search — 2D char grid, check if a word exists (DFS/backtracking, mark visited cells).
•  Merge Intervals — Sort and merge overlapping intervals (useful for transaction/time windows).
•  Anagram checks or string manipulations under constraints.
•  Array/string problems with maps/sets (e.g., find duplicates, group anagrams).
•  General: LeetCode mediums tagged “Karat” — practice timed in Java, explain Big-O aloud.

**4. OOP / Design & Debugging (10 mins)**
•  Design a simple banking class (e.g., Account with deposit/withdraw, make thread-safe).
•  OOP principles in practice: Inheritance vs composition in a banking domain.
•  Fix production bugs: Null in controller, concurrency issues, or broken unit tests.
•  Scenario: Improve code for scalability/security in a microservice.

**5. System Design / Scenarios (Light, 3–5 questions in 10 mins)**
•  Scale a transaction logging system cheaply (cost-saving focus).
•  Handle high load in banking app (caching, DB choice, scaling resources).
•  CAP theorem in banking context (e.g., prioritize consistency/availability).
•  Scenario-based: Save costs for the company while scaling, or handle clock skew in payments.

**Tips from reports: **
Talk constantly (“I’m using a HashMap because…”), **no silent coding**. 

Difficulty is medium overall—focus on clean Java code,** no brute force**. 

If your interview is soon, grind Two Sum / Word Search in Java timed, plus ConcurrentHashMap deep-dive. 
Verbal Mock with ChatGPT/Gemini/Grok Voice avatar.
