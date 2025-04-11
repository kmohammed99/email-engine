# ⚙️ Threading & Async - EmailEngine

## 🚀 Asynchronous Execution
### Enabled via:
```java
@EnableAsync
```

### Configured in:
```java
@Configuration
public class AsyncConfig {
    @Bean("customExecutor")
    public Executor taskExecutor() { ... }
}
```

### Usage:
```java
@Async("customExecutor")
public void sendEmail(...) { ... }
```

✅ Each email is sent in its own thread (non-blocking)

---

## ♻️ Retry Logic
### Annotation:
```java
@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000))
```
- Automatically retries sending when `MailException` occurs
- Works with async methods

### Recovery fallback:
```java
@Recover
public void recover(MailException e, ...) { ... }
```

---

## 🧵 Threads in Action
- Thread names like `EmailThread-1`, `EmailThread-2`
- Managed by Spring's ThreadPoolExecutor
- Logging with `Thread.currentThread().getName()`

---

## 🧠 Threading Concepts Recap
| Concept         | Description |
|----------------|-------------|
| `@Async`       | Runs method in separate thread |
| `Executor`     | Manages threads in a pool |
| `@Retryable`   | Automatically retries failed methods |
| `@Recover`     | Handles final failure gracefully |

---

🔗 [Return to Docs Index](../README.md)

