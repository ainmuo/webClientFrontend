package ma.formations.msa.webclientfrontend.service;

import lombok.AllArgsConstructor;
import ma.formations.msa.webclientfrontend.domaine.EmpVo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class ServiceImpl implements IService{
    private WebClient webClient;
    @Override
    public Flux<EmpVo> getAllEmployees() {
        return webClient.get()
                .uri("/employees")
                .retrieve().bodyToFlux(EmpVo.class);
    }
    @Override
    public Mono<EmpVo> getEmployeeById(Long id) {
        return webClient.get()
                .uri("/employees/{id}",id)
                .retrieve().bodyToMono(EmpVo.class);
    }
    @Override
    public Mono<EmpVo> createEmployee(EmpVo vo) {
        return webClient.post()
                .uri("/employees")
                .bodyValue(vo)
                .retrieve().bodyToMono(EmpVo.class);
    }
    @Override
    public Mono<EmpVo> updateEmployee(Long id, EmpVo vo) {
        return webClient.put()
                .uri("/employees/{id}",id)
                .bodyValue(vo)
                .retrieve().bodyToMono(EmpVo.class);
    }
    @Override
    public Mono<Void> deleteEmployee(Long id) {
        return webClient.delete()
                .uri("/employees/{id}",id)
                .retrieve().bodyToMono(Void.class);
    }
}