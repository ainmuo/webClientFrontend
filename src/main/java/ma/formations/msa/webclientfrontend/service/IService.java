package ma.formations.msa.webclientfrontend.service;

import ma.formations.msa.webclientfrontend.domaine.EmpVo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface IService {
    Flux<EmpVo> getAllEmployees();
    Mono<EmpVo> getEmployeeById(Long ID);
    Mono<EmpVo> createEmployee(EmpVo vo);
    Mono<EmpVo> updateEmployee(Long id,EmpVo vo);
    Mono<Void> deleteEmployee(Long id);
}