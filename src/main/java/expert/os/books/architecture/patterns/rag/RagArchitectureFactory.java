package expert.os.books.architecture.patterns.rag;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class RagArchitectureFactory {


    @Produces
    @ApplicationScoped
    public EmbeddingModel createEmbeddingModel() {
        // A fast, local model for translating text to vectors
        // Outputs a 384-dimensional vector
        return new AllMiniLmL6V2EmbeddingModel();
    }

    @Produces
    @ApplicationScoped
    public EmbeddingStore<TextSegment> createVectorDatabase() {
        // For production, this would be PgVector, Milvus, Qdrant, etc.
        return new InMemoryEmbeddingStore<>();
    }

    @Produces
    @ApplicationScoped
    public ContentRetriever createRetriever(EmbeddingStore<TextSegment> store, EmbeddingModel model) {
        // The architectural bridge that searches the DB based on the query vector
        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(store)
                .embeddingModel(model)
                .maxResults(3) // Fetch the top 3 most relevant chunks
                .minScore(0.7) // Strict boundary: Ignore low-confidence matches
                .build();
    }

    @Produces
    @ApplicationScoped
    public HRPolicyAgent createAgent(ChatModel chatModel, ContentRetriever retriever) {
        // Binds the RAG pipeline to the Agent
        return AiServices.builder(HRPolicyAgent.class)
                .chatModel(chatModel)
                .contentRetriever(retriever)
                .build();
    }
}