import { ReactElement,ReactElementProps,createElement } from "./react-step-1";

type Fiber = {
    tagName: string|"TEXT";
    props: ReactElementProps;
    dom: HTMLElement;
    parent?: Fiber; 
    sibling?: Fiber;
    children?: Fiber[];
};

let nextUnitOfWork:Fiber = null;

function performUnitOfWork(fiber: Fiber):Fiber{
    return null;
}

// 创建fiber树
function workLoop(deadline: IdleDeadline){
    let shouldYield = false;
    while(nextUnitOfWork && !shouldYield){
        nextUnitOfWork = performUnitOfWork(nextUnitOfWork);
        shouldYield = deadline.timeRemaining() < 1;
    }
    requestIdleCallback(workLoop);
}

export function render(element: ReactElement|string,container: HTMLElement){
    
}

