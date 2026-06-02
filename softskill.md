# Soft Skill of the Week — Problem Finding Mindset
"Before you write code, write the problem."

Every time you start a feature, ask yourself:

What is the exact input?
What is the exact expected output?
What can go wrong in between?

Soft Skill — How Enterprise Devs Think About Structure

# In unstructured code, you ask: "Where do I put this?"
In clean architecture, you ask: "What is this code's ONE job?"

Controller = only receives request, calls service, returns response
Service = only contains business logic
Repository = only talks to database
Model = only describes data shape

Optional forces you to consciously handle the case where nothing is found — instead of getting a NullPointerException at 2am in production.

// ❌ Junior way - dangerous
User user = userRepository.findByEmail(email); // could be null!
System.out.println(user.getFullName());         // NullPointerException 💥

// ✅ Senior way - safe
Optional<User> userOpt = userRepository.findByEmail(email);
User user = userOpt.orElseThrow(() -> new RuntimeException("User not found"));